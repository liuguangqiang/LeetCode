package main

import (
	"fmt"
)

func main() {

	blockchain := NewBlockChain()
	blockchain.AddBlock("第一个块")
	blockchain.AddBlock("第二个块")

	for _, block := range blockchain.blocks {
		fmt.Println("------------------------")
		fmt.Printf("Prev. hash: %x\n", block.PreBlockHash)
		fmt.Printf("Data: %s\n", block.Data)
		fmt.Printf("Hash: %x\n", block.Hash)
	}
}
