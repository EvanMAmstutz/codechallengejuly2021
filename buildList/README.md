# Consecutive Failure Counter
## Description
This script takes in a text file containing build numbers build names and success/failure and counts the number of consecutive failures have occured for each build name
## Usage
Run `groovy buildListParser.groovy <input_file>`
## Inputs
file
* must be passed as an argument on the commandline
* can be relative or absolute path
* build strings must be in the form of <build-number> <build-name> <success-or-fail>
* <build-name> must not have any spaces
* see buildList.txt for an example
## Example
### Input
`groovy buildListParser.groovy buildList.txt`
### Output

	test1's most consecutive failures: 4
    
    test3's most consecutive failures: 2
    
    test2's most consecutive failures: 3
    
    test5's most consecutive failures: 0
    
    test67's most consecutive failures: 0