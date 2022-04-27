
# __Merkle Tree__

#### Merkle Tree are data stracture to store information and what makes it unique is the data integrity which can be eaily implement with the help of Merkle Tree 
#### Merkle Tree is named after Ralph Merkle, who is one of inventor of public-private key cryptography

## __Architecture of Merkle Tree__

In the image below, we have a full and complete binary tree. In this binary tree 
- Each leaf node has the actuall data that we like to store. 
- Each Internal node represent the hash of it child nodes
- And there is one root node that store the hash of it child node. And this root node is alone sufficient to maintain and check the data integrity of the complete data that is stored in all leaf

![Merkle Tree](https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Hash_Tree.svg/1280px-Hash_Tree.svg.png)


###### __Architecture of Nodes in Merkle Tree__
- Each Leaf Node need to store the data only.
- Each Internal Node need to store the hash value, left subtree and right subtree.
- Root Node need to store the hash value, left-sub tree and right sub-tree.

```java
public class Node {
    private String hash;
    private Node leftTree;
    private Node rightTree;
}
```


## __Algorithm of Merkle Tree__

* Hash Function
    * In simple words, a Hash Function is used to store the original data into different format or form, so that it can not be retervied by unknow entities easily
    * In Merkle Tree, Hash Function is used to Hash the data stored in leaf node and then keep on hashing the result to the root node.
    * In this was each Internal Node is the hash of its child nodes and root node is the hash of the whole tree.
    * Benifit of using Hash Function in Merkle Tree is that even a small change in the child can effect its parent and then parent will effect its parent; and this preocess propogarte till the root node. This effect is called avalanche effect. It makes impossible for someone to manipluate the history stored in Merkle Trees


## Refrence
[Merkle Tree: Implementation in java and its real world applications](https://www.pranaybathini.com/2021/05/merkle-tree.html)

[Merkle tree](https://en.wikipedia.org/wiki/Merkle_tree)

[MD5 Message Digest Algorithm](https://reflectoring.io/creating-hashes-in-java/)

## Misc

Note: Merkle Tree is a USPTO patented Algorithm/ Data Structure and hence, you cannot use it in production without permission or by paying royality to Ralph Merkle. Merkle Tree is also known as Hash Tree.



