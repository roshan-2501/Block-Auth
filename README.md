Digitized papers are becoming more and more popular among businesses and individual users due to the quick progress of information sharing and exchange. Furthermore, the laborious and time-consuming procedure of using and validating old physical documents encourages people to embrace more contemporary methods for issuing and verifying significant documents. While using digital documents is definitely more convenient, verifying their legitimacy is frequently a source of worry. The ease of access to affordable, sophisticated equipment and the advancement of technology have made it possible for critical documents to be easily faked, making document authentication a laborious process. The implications surrounding the issue of fraudulent documents are grave and concerning, and they require immediate attention.
Users would therefore tremendously benefit from a method to verify the validity of crucial papers in order to preserve their digital documents. To address this issue, there is an open-source, consensus-based, immutable approach called blockchain. Recently, blockchain technology has been developed to improve document verification and complicate the process of lowering document fraud and misuse. In essence, blockchain functions as a decentralized database. that is
linked together in a chronological order, with each block or data pack holding information in a fashion that prevents manipulation. Blockchain is a cutting-edge technology that can help the sector overcome any setbacks by playing a number of important roles. Blockchain guarantees safety, autonomy, consensus, integrity, and trust.

PROJECT MODULES:
There are Four modules:
• User Registration And Authentication
• User Upload Certificate
• Get Certificate
• QR Request And Response From Verification Authority

User Registration and Authentication:
Upon completing the module registration process, users will initiate an authentication request to the central board server. Access to the user's account is contingent upon approval from the central board server; if the request is denied, account access is restricted. Conversely, once approval is granted by the central board server, a unique key is generated, permitting the user to access their account.

User Upload Certificate:
Upon logging into their account, users are required to upload their voters ID, Aadhar card, Pan Card, and SSC certificates to the central board server. Subsequently, the central board server evaluates the uploaded certificates to determine acceptance or rejection. Approved certificates undergo storage in both Blockchain and E.C.S. (Electronic Certificate System). Conversely, certificates rejected by the central board server are not retained in either E.C.S. or Blockchain.

Get Certificate:
When a user requires a certificate, they will submit a request to the central board server. Following verification of the user's information for authenticity, the central board server will authorize the request and transmit it to E.C.S., the repository for all certificates. Subsequently, upon E.C.S.'s response to the request, the certificates will be dispatched to the user.

QR Request and Face verification:
When a user seeks to apply for certificates, they submit a request to the central board server. Following verification of the details provided, the central board server forwards the request to E.C.S. Subsequently, E.C.S. generates a unique QR Code, which is then transmitted to the user through the central board server. Upon confirmation of the accuracy of all data and successful matching of the user's face with their real identity, the document is issued upon presentation of the QR code to the verifying authority.

ALGORITHM :
The BLOCK-AUTH project employs the K-nearest neighbors (KNN) algorithm for document similarity assessment and authentication. KNN is a supervised machine learning algorithm widely utilized for classification and regression tasks.
The KNN algorithm works within the context of BLOCK-AUTH:

Document Representation:
Each document is represented as a feature vector, where the features may include various characteristics such as document structure, content, metadata, or any other relevant attributes. These features serve as the basis for comparing the similarity between different documents.

Training Phase:
During the training phase, the algorithm builds a database of previously authenticated documents along with their corresponding feature vectors. Each document in the database is labeled with its authenticity status (e.g., authentic or suspicious).

Similarity Measurement:
Upon submission of a new document for authentication, the KNN algorithm computes the similarity between the features of the submitted document and those already present in the database. This process can utilize different distance metrics, including but not limited to Euclidean distance or cosine similarity, to gauge the similarity between feature vectors.

K-nearest Neighbors:
Based on the calculated similarities, the algorithm identifies the K nearest neighbors (i.e., the K documents with the most similar features) to the submitted document. .The value of K is a parameter that can be chosen based on the specific requirements of the application.

Classification:
Once the K nearest neighbors are identified, the algorithm determines the authenticity of the submitted document based on the majority class of its neighbors. For example, if the majority of the nearest neighbors are labeled as authentic documents, the submitted document is classified as authentic as well.

Decision Rule:
The algorithm may use a simple majority voting rule or weighted voting scheme to determine the class label of the submitted document based on the labels of its nearest neighbors.

Output:
Finally, the KNN algorithm outputs the classification result, indicating whether the submitted document is classified as authentic or suspicious.
