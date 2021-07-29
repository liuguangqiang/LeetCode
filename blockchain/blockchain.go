package main

// BlockChain 是一个 Block 指针数组
type BlockChain struct {
	blocks []*Block
}

// 创建一个有创世块的区块链
func NewBlockChain() *BlockChain {
	return &BlockChain{[]*Block{NewGenesisBlock()}}
}

// AddBlock 向区块链中加入一个新块
// data 在实际中就是交易
func (bc *BlockChain) AddBlock(data string) {
	length := len(bc.blocks)
	prevBlock := bc.blocks[length-1]
	newBlock := NewBlock(data, prevBlock.Hash)
	bc.blocks = append(bc.blocks, newBlock)
}
