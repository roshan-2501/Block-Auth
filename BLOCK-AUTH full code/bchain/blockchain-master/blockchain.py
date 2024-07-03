import json
from time import time
import hashlib
from uuid import uuid4
import datetime

import os.path
import pickle

import requests
from flask import Flask, jsonify, request


class Blockchain:
    def __init__(self):
        self.transactions = []
        self.bchain = []

        if(os.path.isfile("translist.dat")):
            with open("translist.dat", "rb") as fp:
                self.bchain = pickle.load(fp)
        else:
            self.new_block(previous_hash='1', proof=100)
            
            
        self.nodes = set()


    def create_block(self, proof, previous_hash):

        block = {
            'index': len(self.bchain) + 1,
            'timestamp': time(),
            'transactions': self.transactions,
            'proof': proof,
            'previous_hash': previous_hash or self.hash(self.bchain[-1]),
        }

        self.transactions = []

        self.bchain.append(block)
        with open("translist.dat", "wb") as fp:
           pickle.dump(self.bchain, fp)
        return block

    def create_transaction(self, sender, recipient, amount):
        self.transactions.append({
            'sender': sender,
            'recipient': recipient,
            'amount': amount,
        })

        return self.prev_block['index'] + 1
    def clear(self):
        self.bchain = []
        self.create_block(previous_hash='1', proof=100)
        with open("translist.dat", "wb") as fp:
           pickle.dump(self.bchain, fp)
        

    @property
    def prev_block(self):
        return self.bchain[-1]

    @staticmethod
    def hash(block):
        block_string = json.dumps(block, sort_keys=True).encode()
        return hashlib.sha256(block_string).hexdigest()

    def proof_work(self, prev_block):

        prev_proof = prev_block['proof']
        prev_hash = self.hash(prev_block)

        proof = 0
        while self.valid_proof(prev_proof, proof, prev_hash) is False:
            proof += 1

        return proof

    @staticmethod
    def valid_proof(prev_proof, proof, prev_hash):

        guess = f'{prev_proof}{proof}{prev_hash}'.encode()
        guess_hash = hashlib.sha256(guess).hexdigest()
        return guess_hash[:4] == "0000"


app = Flask(__name__)

id_node = str(uuid4()).replace('-', '')


blockchain = Blockchain()


@app.route('/mine', methods=['GET'])
def mine():
    prev_block = blockchain.prev_block
#    print("Proof Start ",datetime.datetime.now())
    proof = blockchain.proof_work(prev_block)
#    print("Proof End ",datetime.datetime.now())

    blockchain.create_transaction(
        sender="0",
        recipient=id_node,
        amount=1,
    )

    prev_hash = blockchain.hash(prev_block)
    block = blockchain.create_block(proof, prev_hash)

    response = {
        'message': "New Block Create",
        'index': block['index'],
        'transactions': block['transactions'],
        'proof': block['proof'],
        'previous_hash': block['previous_hash'],
    }


    return jsonify(response), 200


@app.route('/transactions/new', methods=['POST'])
def create_transaction():
    values = request.get_json()
    print(values)

    # Check that the required fields are in the POST'ed data
    req = ['sender','recipient','amount'  ]
    if not all(k in values for k in req):
        return 'Missing values', 400

#    print("New Trans Start ",datetime.datetime.now())


    index = blockchain.create_transaction(values['sender'], values['recipient'], values['amount'])
#    print("New Trans End ",datetime.datetime.now())

    response = {'message': f'Transaction added to Block {index}'}
    return jsonify(response), 201


@app.route('/chain', methods=['GET'])
def print_chain():
    response = {
        'chain': blockchain.bchain,
        'length': len(blockchain.bchain),
    }
    return jsonify(response), 200


@app.route('/clear', methods=['GET'])
def clear():
    blockchain.clear()
    response = {'message': f'Transaction Cleared'}
    return jsonify(response), 201





if __name__ == '__main__':
    from argparse import ArgumentParser

    parser = ArgumentParser()
    parser.add_argument('-p', '--port', default=5000, type=int, help='port to listen on')
    args = parser.parse_args()
    port = args.port

    app.run(host='0.0.0.0', port=port)
