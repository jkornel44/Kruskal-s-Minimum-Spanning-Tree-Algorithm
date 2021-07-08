# Kruskal-s-Minimum-Spanning-Tree-Algorithm
Kruskal's Minimum Spanning Tree Algorithm written in Java.

## Usage
First you need to make a .txt file with the following rules:

- the first row contains the numbers of vertices
- the following n rows contain the vertices, represented by two value (x, y), separated by commas.

### Example input file
```sh
7
12,4
4,7
3,1
5,5
12,7
11,3
4,1
```

### Expected output on console
```sh
Minimum Spanning Tree:
[
[2](3.0,1.0) 	  [6](4.0,1.0) 		1.0, 
[0](12.0,4.0) 	[5](11.0,3.0) 	1.4142135623730951, 
[1](4.0,7.0) 	  [3](5.0,5.0) 		2.23606797749979, 
[0](12.0,4.0) 	[4](12.0,7.0) 	3.0, 
[3](5.0,5.0) 	  [6](4.0,1.0) 		4.123105625617661, 
[3](5.0,5.0) 	  [5](11.0,3.0) 	6.324555320336759]
```
