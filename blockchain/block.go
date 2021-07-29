package main

import (
	"bytes"
	"crypto/sha256"
	"strconv"
	"time"
)

// 区块
// Block 由区块头和交易两部分构成
// Timestamp 是当前时间戳，也就是区块创建的时间
// Data 是区块存储的实际有效的信息
// PrevBlockHash 存储的是前一个块的哈希
// Hash 是当前块的哈希

// 在比特币技术规范中，Timestamp, PrevBlockHash, Hash 是区块头（block header），区块头是一个单独的数据结构。
//而交易，也就是这里的 Data, 是另一个单独的数据结构。为了简便起见，我把这两个混合在了一起
type Block struct {
	Timestamp    int64
	Data         []byte
	PreBlockHash []byte
	Hash         []byte
}

// 计算Hash
// Hash = sha256(PrevBlockHash + Data + Timestamp)
func (b *Block) setHash() {
	timestamp := []byte(strconv.FormatInt(b.Timestamp, 10))
	headers := bytes.Join([][]byte{b.PreBlockHash, b.Data, timestamp}, []byte{})
	hash := sha256.Sum256(headers)
	b.Hash = hash[:]
}

// NewBlock 用于生成新块，参数需要 Data 与 PrevBlockHash
// 当前块的哈希会基于 Data 和 PrevBlockHash 计算得到
func NewBlock(data string, prevBlockHash []byte) *Block {
	block := &Block{time.Now().Unix(), []byte(data), prevBlockHash, []byte{}}
	block.setHash()
	return block
}

// NewGenesisBlock 生成创世块
func NewGenesisBlock() *Block {
	return NewBlock("Genesis Block", []byte{})
}
