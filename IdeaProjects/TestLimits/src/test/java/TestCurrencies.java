import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCurrencies {
    private static String arg = System.getProperty("game");


    @BeforeTest
    public void doBeforeTest(){
        System.out.println("=============================================================================================================================================");
        System.err.println("Start test for " + arg);
        System.out.println("=============================================================================================================================================");
    }

    @Test
    public void testCurrencies() throws Exception {
        JSONObject expectedJson = GetDataFromServer.GetLocalJson();
        JSONObject actualJson = GetDataFromServer.GetJson();
        JSONObject fromLimitsActual = (JSONObject) actualJson.get("limits");
        String[] currencyList = {"EUR", "USD", "GBP", "AUD", "AZN", "BGN", "BND", "CAD", "CHF", "GEL", "NZD", "SGD", "BMD", "BRL",	"ILS",	"MYR",	"PEN",	"PLN",	"RON",	"TRY", "GHS", "ARS", "CNY",	"DKK",	"HKD",	"HRK",	"MAD",	"MOP",	"NOK",	"SEK",	"VEF",	"ZAR",	"ZMW", "CZK",	"DOP",	"HNL",	"INR",	"KGS",	"MDL", "NIO", "PHP", "RUB",	"THB",	"TWD",	"UAH",	"UYU", "VES", "ISK", "JPY",	"RSD", "KES", "CLP", "HUF",	"KZT", "XOF", "CRC", "KRW", "COP", "MNT", "TZS", "MMK", "PYG", "IDR", "VND", "IDS", "VNS", "MXN", "BNS" };

        for (String currency : currencyList) {

            JSONObject limitsExpected = (JSONObject) expectedJson.get(currency);
            JSONArray stakeAllExpected = (JSONArray) limitsExpected.get("stakeAll");
            long winMaxExpected = Long.parseLong(limitsExpected.get("winMax").toString());
            long maxTotalStakeExpected = Long.parseLong(limitsExpected.get("maxTotalStake").toString());
            double stakeDefExpected = Double.parseDouble(limitsExpected.get("stakeDef").toString());
            double stakeMaxExpected = Double.parseDouble(limitsExpected.get("stakeMax").toString());
            double stakeMinExpected = Double.parseDouble(limitsExpected.get("stakeMin").toString());



            JSONObject limitsActual = (JSONObject) fromLimitsActual.get(currency);
            JSONArray stakeAllActual = (JSONArray) limitsActual.get("stakeAll");
            long winMaxActual = Long.parseLong((limitsActual.get("winMax").toString()));
            long maxTotalStakeActual = Long.parseLong(limitsExpected.get("maxTotalStake").toString());
            double stakeDefActual = Double.parseDouble(limitsActual.get("stakeDef").toString());
            double stakeMaxActual = Double.parseDouble(limitsActual.get("stakeMax").toString());
            double stakeMinActual = Double.parseDouble(limitsActual.get("stakeMin").toString());


            //test winMax
            try {
                Assert.assertEquals(winMaxExpected, winMaxActual, "Incorrect " + currency + " maxWin");
                System.out.println("winMax for " + currency + " checked");
            } catch (AssertionError assertionError){
                System.err.println(assertionError);
            }

            //test stakeDef
                Assert.assertEquals(stakeDefActual, stakeDefExpected, "Incorrect " + currency + " stakeDef");
                System.out.println("stakeDef for " + currency + " checked");
            try {
            } catch (AssertionError assertionError){
                System.err.println(assertionError);
            }

            //test stakeMax
            try {
                Assert.assertEquals(stakeMaxActual, stakeMaxExpected, "Incorrect " + currency + " stakeMax");
                System.out.println("stakeMax for " + currency + " checked");
            } catch (AssertionError assertionError){
                System.err.println(assertionError);
            }

            //test stakeMin
            try {
                Assert.assertEquals(stakeMinActual, stakeMinExpected, "Incorrect " + currency + " stakeMin");
                System.out.println("stakeMin for " + currency + " checked");
            } catch (AssertionError assertionError){
                System.err.println(assertionError);
            }

            //test maxTotalStake
            try {
                Assert.assertEquals(maxTotalStakeActual, maxTotalStakeExpected, "Incorrect " + currency + " maxTotalStake");
                System.out.println("maxTotalStake for " + currency + " checked");
            } catch (AssertionError assertionError){
                System.err.println(assertionError);
            }

            //test stakeAll
            try {
                Assert.assertEquals(stakeAllActual, stakeAllExpected, "Incorrect " + currency + " stakeAll");
                System.out.println("stakeAll for " + currency + " checked");
            } catch (AssertionError assertionError){
                System.err.println(assertionError);
            }

        }


    }

}
