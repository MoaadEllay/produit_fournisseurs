package View;
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://127.0.0.1:8082")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
		"Accept" -> "*/*",
		"Pragma" -> "no-cache")

    val uri1 = "http://127.0.0.1:8082/ProduitsFournisseursServlet"
    val uri2 = "http://detectportal.firefox.com/success.txt"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.post("/ProduitsFournisseursServlet/Login")
			.headers(headers_0)
			.formParam("email", "admin@gmail.com")
			.formParam("password", "admin"))
		.pause(7)
		.exec(http("request_1")
			.get("/ProduitsFournisseursServlet/index.jsp")
			.headers(headers_0)
			.resources(http("request_2")
			.get(uri2 + "")
			.headers(headers_2),
            http("request_3")
			.get(uri2 + "")
			.headers(headers_2)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}