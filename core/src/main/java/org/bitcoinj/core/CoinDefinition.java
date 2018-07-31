package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "AlarmX";
    public static final String coinTicker = "ALRMX";
    public static final String coinURIScheme = "alarmx";
    public static final String cryptsyMarketId = "0";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[6]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[Q]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://explorer.alarmx.io/ext/getmoneysupply";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.alarmx.io/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.explorer.alarmx.io/";

    public static final String DONATION_ADDRESS = "NULL";  //Hash Engineering donation ALRMX address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 100000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 ALRMX (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // Alarmx 0.12.1.x
    //
    public static final int PROTOCOL_VERSION = 70208;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70206;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 2579;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 12579;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 23;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 21;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 158;   //common to all coins
    public static final long oldPacketMagic = 0xc3b90d8f;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xc3b90d8f;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1531677300;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (1404078);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000ec2fe479009adc2c1f99ce83c436eda3e7d4063c06659688832280287de"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "c62f15b952279574c241108190da39853ba103c26ac0a5994d63615ee4c45fec";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01043a5468652054656c6567726170682031352f4a756c792f32303138204672616e63652057696e732032303138204649464120576f726c6420437570";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "seed1.alarmx.io",
            "seed2.alarmx.io",
            "seed3.alarmx.io",
            "seed4.alarmx.io",
            "seed5.alarmx.io",
            "seed6.alarmx.io",
            "seed7.alarmx.io",
            "seed8.alarmx.io",
            "seed9.alarmx.io",
            "seed10.alarmx.io"
    };


    public static int minBroadcastConnections = 0;   //0 for default; Using 3 like BreadWallet.

    //
    // TestNet - ALRMX
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 140;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xc1b20a8f;      //
    public static final String testnetGenesisHash = "0x000008851c851820bd2bcbf6a94c30270cea762885555a3c3ff95166e996e28e";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1531677600;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (124508);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(100, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(30000000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210240;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.alarmx.io",
            "test.dnsseed.alarmx.io",
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "0417031dde615e7b2c6fb32b409d91cbf6d7bb164cec7d0618bfbeecc329e02aea847f8442726c1af1c798631f090e7c3500b66a2f51b3ffb1ea816be44a33bf4d";
    public static final String TESTNET_SATOSHI_KEY = "04c3eb543e60cbdee85d6d5980697e389cd554db60203407a33f8e370af93e2836ed29030e77f3165d7bfc8a966620c351b7f8c226f14f66ddd7578b5899650834";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.darkcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.darkcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

        checkpoints.put(  0, Sha256Hash.wrap("0x000008851c851820bd2bcbf6a94c30270cea762885555a3c3ff95166e996e28e"));
        //checkpoints.put( 16912, Sha256Hash.wrap("00000000075c0d10371d55a60634da70f197548dbbfa4123e12abfcbc5738af9"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "APpKWiMhp3f7uoAEiH7XeMHVKDryCgpBEu";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "QWquNkM5Ghpamz1q1ZcNCET9L34Vs5ZUpC2GpVJkCFgHpbhdhehr";

}
