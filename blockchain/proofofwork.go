package main

import "math/big"

// https://github.com/liuchengxu/blockchain-tutorial/blob/master/content/part-2/proof-of-work.md

/**
在比特币中， 当一个块被挖出来之后， targetBits代表区块链里存储的难度， 也就是开头有多少个0；
这里的24 指算出来的哈希前24位必须为0， 如果用16进制表示， 就是前6位必须是0；
*/
const targetBits = 24

type ProofOfWork struct {
	block  *Block
	target *big.Int
}

/**
我们将 big.Int 初始化为 1，然后左移 256 - targetBits 位。256 是一个 SHA-256 哈希的位数，我们将要使用的是 SHA-256 哈希算法。target（目标） 的 16 进制形式为：
0x10000000000000000000000000000000000000000000000000000000000
*/
func NewProofOfWork(b *Block) *ProofOfWork {
	target := big.NewInt(1)
	target.Lsh(target, uint(256-targetBits))
	pow := &ProofOfWork{b, target}
	return pow
}
