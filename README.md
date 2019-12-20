# UDS   ![GitHub top language](https://img.shields.io/github/languages/top/UriahShaulMandel/UDS)
Uriah's Data Structs - Simple data structs library I made 2 years ago in order to learn java programming
```
Uriah's Data Structs (UDS)
├───BinTree.java
├───DataStructure.java
│   ├───Queue.java
│   │   ├───NodeQueue.java
│   │   └───StackArrayQueue.java
│   └───Stack.java
│       ├───ArrayStack.java
│       └───NodeStack.java
└───Node.java
```


The thing that's cool about this library is that `DataStructure`, the base of most of the classes, implements `java.util.Collection` and `java.util.Iterable`.
That means for each loops can be used:
```java
Stack<Integer> s = new ArrayStack<>();
...
for(int i : s){
...
}

```
and that UDS can be used with other java classes:
```java
Stack<Integer> stk = new ArrayStack<>();
java.util.Set<Integer> set = new java.util.HashSet<>(stk);
```
And java 8 lambdas:
```java
Stack<Integer> stk = new ArrayStack<>();
...
stk.forEach(System.err::println);
```
 
 ## Features
 - `hashCode` and `equals`
 - for each
 - java 8 lambdas
 - Generics
 - `toString()`
 - `java.util.Collection` features and methods
 - `contains` and `containsAll`
 - `toArray`
 - `addAll`
