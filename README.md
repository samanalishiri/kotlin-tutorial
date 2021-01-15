# kotlin-tutorial step by step 

# Online Shopping
### Background:
A shopping used the price of their produce on an individual item cost. Also, the shopping 
provides prepackaging ability for some items, it means if a customer wants to buy the items he will 
receive a few packed produce. The packed produce is chipper than sum of product cost. 

The shopping is able to apply discount to products.

A sample for prepacked product:

| name             | code         | pack                             |
| :---:            | :---:        | :---:                            |
| Vegemite         | Scroll VS5   | 3 @ $6.99, 5 @ $8.99             |
| Blueberry Muffin | MB11         | 2 @ $9.95, 5 @ $16.95, 8 @ $24.95|
| Croissant        | CF           | 3 @ $5.95, 5 @ $9.95, 9 @ $16.99 |
### Story:
Given a customer order you are required to determine the cost and pack breakdown for each product.
To save on shipping space each order should contain the minimal number of packs.
##### Input:
Each order has a series of lines with each line containing the number of items followed by the
product code. An example input:
```
10 VS5
14 MB11
13 CF
```
##### Output:
A successfully passing test(s) that demonstrates the following output:
```
10 VS5 $17.98
    2 x 5 $8.99
14 MB11 $54.8
    1 x 8 $24.95
    3 x 2 $9.95
13 CF $25.85
    2 x 5 $9.95
    1 x 3 $5.95
```
### Prerequisites
- Java 8
- Kotlin  
- maven 3

### Build
`mvn clean install`

### Test
`mvn clean packge test`

### Sonar
run `sonar-scanner` command in project root folder
