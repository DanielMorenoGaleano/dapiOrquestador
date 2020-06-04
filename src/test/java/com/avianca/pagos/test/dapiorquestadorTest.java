package com.avianca.pagos.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avianca.pagos.rest.dto.RequestDTO;
import com.avianca.pagos.rest.dto.RequestRecordDTO;
import com.avianca.pagos.rest.dto.RequestRemarksDTO;

/**
 * 
 * @author Assert Solutions S.A.S <info@assertsolutions.com> <br/>
 *         Date: 9/04/2018 9:17:11 a.m.
 * 
 */
public class dapiorquestadorTest extends CamelSpringTestSupport {

	private static final String PROPERTIES_FILE_DIR = "src/test/resources/";
	private static Properties testProperties = new Properties();

	//Request Notifications
	@Test
	public void testRoute() throws Exception {
		final String fromRoute = "direct:fromRoute";

		context.getRouteDefinition("restServerRoute").adviceWith(context, new AdviceWithRouteBuilder() {
			@Override
			public void configure() throws Exception {
				replaceFromWith(fromRoute);
				weaveAddLast().log("Finishing the unit test of the route ").to("mock://endroute");
			}
		});
		context.start();
		// Agregamos un mock endpoint
		MockEndpoint mockEndpoint = getMockEndpoint("mock://endroute");
		mockEndpoint.expectedMinimumMessageCount(1);
		RequestDTO request = new RequestDTO();
		request.setAutorizacion("09088734");
		request.setFranquicia("CA");
		request.setCanal("AVCOM");
		request.setTc("909876XXXXX9876");
		request.setMedio("TC");
		request.setPais("CO");
		request.setPnr("VC9O2R");
		request.setLastName("Palma");
		template.sendBody(fromRoute, request);

		mockEndpoint.assertIsSatisfied(2000L);
	}
	
	//Request REMARKS
	//@Test
	public void testRouteRemarks() throws Exception {
		final String fromRoute = "direct:fromRoute";

		context.getRouteDefinition("restServerRoute").adviceWith(context, new AdviceWithRouteBuilder() {
			@Override
			public void configure() throws Exception {
				replaceFromWith(fromRoute);
				weaveAddLast().log("Finishing the unit test of the route ").to("mock://endroute");
			}
		});
		context.start();
		// Agregamos un mock endpoint
		MockEndpoint mockEndpoint = getMockEndpoint("mock://endroute");
		Map<String, Object> map = new HashMap<>();
		map.put("CamelHttpPath", "/remarks");
		mockEndpoint.expectedMinimumMessageCount(1);
		RequestRemarksDTO request = new RequestRemarksDTO();;
		request.setFreetext("COUPON MR2D2TBFGJRDIM2QGVLUE2BTLJ4HQZCIG5DXMNT2NFISKM3EEUZWI===");
		request.setPnr("UMDKPK");
		request.setLastName("Palma");
		template.sendBodyAndHeaders(fromRoute, request,map);

		mockEndpoint.assertIsSatisfied(2000L);
	}
	//Request RECORDS
	//@Test
	public void testRouteRecords() throws Exception {
		final String fromRoute = "direct:fromRoute";

		context.getRouteDefinition("restServerRoute").adviceWith(context, new AdviceWithRouteBuilder() {
			@Override
			public void configure() throws Exception {
				replaceFromWith(fromRoute);
				weaveAddLast().log("Finishing the unit test of the route ").to("mock://endroute");
			}
		});
		context.start();
		String json ="{\"paymentRequests\":[{\"paymentMethod\":{\"paymentType\":\"ExternalPayment\",\"externalPaymentRecordId\":\"909876XXXXX9876\"}}]}";
		// Agregamos un mock endpoint
		MockEndpoint mockEndpoint = getMockEndpoint("mock://endroute");
		Map<String, Object> map = new HashMap<>();
		map.put("CamelHttpPath", "/records");
		mockEndpoint.expectedMinimumMessageCount(1);
		RequestRecordDTO request = new RequestRecordDTO();;
//		request.setBody(json);
		request.setPnr("UMEU6F");
		request.setLastName("Palma");
		template.sendBodyAndHeaders(fromRoute, request,map);

		mockEndpoint.assertIsSatisfied(2000L);
	}

	/**
	 * Carga del archivo de propiedades para los Test Unitarios
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void init() throws Exception {
		testProperties.load(dapiorquestadorTest.class.getResourceAsStream("/dapiorquestador.properties"));
	}

	@BeforeClass
	public static void setUpProperties() throws Exception {
		System.setProperty("karaf.home", PROPERTIES_FILE_DIR);
		System.setProperty("project.artifactId", "Test-Maven-Artifact");
	}

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml", "META-INF/spring/properties-beans.xml");
	}

}
