package com.example.jeedemo.restclients;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
//
//@Path("post-demo")
//@Consumes("multipart/form-data")
public class PostDemoResource {

//  @Inject private PostDemoService service;
//
//  @Inject
//  @Service(ServiceProvider.IDOLOGY)
//  CustomerVerify customerVerify;
//
//  @POST
//  public Response testWebhook(String response){
//    System.out.println(response);
//    System.out.println("hewllo");
//
//    return Response.serverError().build();
//  }
//
//  @Inject private AmazonS3Service amazonS3Service;
//
//  @GET
//  public String fetch() throws IOException {
//
//
//    File file = new File("/home/shankar/Pictures/pubge.jpg");
//    InputStream in = new FileInputStream(file);
//
//    CipRequest cipRequest = new CipRequest();
//    cipRequest.setBackImage(in);
//    in = new FileInputStream(file);
////    cipRequest.setFrontImage(in);
//    cipRequest.setDocumentType("driverLicense");
//    cipRequest.setCountryCode("USA");
//    cipRequest.setAddressLine1("222333 PEACHTREE PLACE ");
//    cipRequest.setFirstName("JOHN ");
//    cipRequest.setLastName("SMITH");
//    cipRequest.setPostalCode("30318");
//    cipRequest.setSenderId("1234");
//    cipRequest.setCity("ATLANTA");
//    cipRequest.setState("GA");
//    cipRequest.setSsnLast4("3333");
//
//
//    Thread thread = Thread.currentThread();
//    thread.setName("shankar-thread");
//
//    return customerVerify.verifySender(cipRequest).toString();
//
//    //		OutputStream outputStream = null;
//    //		java.util.Base64.getEncoder().wrap(outputStream);
//    //
//    //		String tempUrl = amazonS3Service.getTempUrl(
//    //
//    //	"machpay-api/uploads/personal/sender/9e365fac-84fb-4e63-9335-4bbfe4c2268c/kyc/DRIVING_LICENCE_2018-04-27T05:15:27.330.png",
//    //			10L);
//    //		out.println(tempUrl);
//    //
//    //		try {
//    //			File file = FileUtils.getFile(tempUrl);
//    //
//    //			String s = encodeFileToBase64Binary(file);
//    //      out.println("----------------------------------");
//    //      out.println(s);
//    //
//    //
//    //		} catch (IOException e) {
//    //			e.printStackTrace();
//    //		}
//    //
//    //		CipRequest customerInfo = new CipRequest();
//
//    //
//    //    out.println(customerVerify.toString());
//    //
//    //		return customerVerify.verifySender(customerInfo).toString();
//  }
//
//  private static String encodeFileToBase64Binary(File file) throws IOException {
//    byte[] encoded = Base64.encodeBase64(org.apache.commons.io.FileUtils.readFileToByteArray(file));
//    return new String(encoded, StandardCharsets.US_ASCII);
//  }
//
//  @POST
//  @Consumes({MediaType.APPLICATION_JSON})
//  public void printPost(@Context HttpHeaders headers, String info) {}
//
//  private void print(Map.Entry<String, List<String>> header) {
//    String value = header.getValue().stream().collect(Collectors.joining(", "));
//    System.out.println(header.getKey() + ": " + value);
//  }
//
//  private static String mapTOJsonString(Map<String, Object> event) {
//    Jsonb jsonb = JsonbBuilder.create();
//
//    return jsonb.toJson(event);
//  }
}
