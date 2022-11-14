package blockch;

import java.util.ArrayList;

public class Test {
        public static ArrayList<Block> blockChain = new ArrayList<>();

        public static Boolean isChainValid() {
                Block currentBlock;
                Block previousBlock;
                for (int i = 1; i < blockChain.size(); i++) {
                        currentBlock = blockChain.get(i);
                        previousBlock = blockChain.get(i - 1);
                        if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                                System.out.println("not equal hashes");
                                return false;
                        }
                        if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                                System.out.println("Previous Hashes are not equal");
                                return false;
                        }
                }
                return true;
        }

        public static void main(String[] args) {
                int prefix = 4;
                String prfixString = "0000";
                Block firstBlock = new Block("first Block.",
                                "0000");
                firstBlock.mineBlock(prefix);
                if (firstBlock.calculateHash().substring(0, prefix).equals(prfixString)) {
                        blockChain.add(firstBlock);
                } else {
                        System.out.println("the block can't be minned");
                }

                Block secondBlock = new Block("second Block.",
                                blockChain.get(blockChain.size() - 1).calculateHash());
                secondBlock.mineBlock(prefix);
                if (secondBlock.calculateHash().substring(0, prefix).equals(prfixString)) {
                        blockChain.add(secondBlock);
                } else {
                        System.out.println("the block can't be minned");
                }

                Block thirdBlock = new Block("third Block.",
                                blockChain.get(blockChain.size() - 1).calculateHash());
                thirdBlock.mineBlock(prefix);
                if (thirdBlock.calculateHash().substring(0, prefix).equals(prfixString)) {
                        blockChain.add(thirdBlock);
                } else {
                        System.out.println("the block can't be minned");
                }

                for (int i = 0; i < blockChain.size(); i++) {
                        System.out.println(blockChain.get(i).toSting());
                }
                System.out.println("----------------------------------------------");

                System.out.println(isChainValid() ? "Your BlockChain is Valid" : "Your BlockChain is not valid");
        }
}
