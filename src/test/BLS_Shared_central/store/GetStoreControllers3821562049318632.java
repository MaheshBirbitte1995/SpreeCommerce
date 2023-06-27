package store;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import BLS_utility.Propper_bls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetStoreControllers3821562049318632 {
	@Test
	public void getController() throws IOException {
		
RestAssured.baseURI =Propper_bls.promp("BLS_url");
		
		Response r = given()
				.contentType(ContentType.JSON)
				
				.header("token",Propper_bls.promp("access_token"))
				.header("Access_key",Propper_bls.promp("access_key") )
				.header("Application_id", Propper_bls.promp("application_id"))
				.header("Account_id",Propper_bls.promp("account_id"))
				.header("controller_id",Propper_bls.promp("controller_id"))
				.header("prd_id",Propper_bls.promp("prd_id"))
				
				.body("{\r\n"
						+ "    \"bu_id\": \"123\"\r\n"
						+ "}")
				.when()
				.post("/api/v1/service_contract/3821562049318632?offset=0&limit=10")
				.then()
				.log().all().extract().response();
		System.out.println("Code "+r.getStatusCode());
		System.out.println(r.timeIn(TimeUnit.SECONDS)+" sec");
	}

}
