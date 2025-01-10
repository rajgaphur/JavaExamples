package com.http;

public class Test {

	public static void main(String[] args) {
																																															  //https://lme.oam.lab1.t-mobile.com:20443/v1/data/23-smpc-LAB1ESMLC/smpc;
																																															  //https://lme.oam.lab2.t-mobile.com:20443/v1/data/21-smpc-LAB2ESMLC/smpc
		//https://lme.oam.iotlab1.t-mobile.com:20443/v1/data/21-smpc-ESMLC7/smpc;
	    //https://lme.oam.iotlab2.t-mobile.com:20443/v1/data/21-smpc-ESMLC8/smpc
		//String cmd1 = "curl -m 5 -kv -H Content-Type:application/json -X POST -d '{\"auth\":{\"method\": \"password\",\"password\": {\"user_id\": \"smpProv\",\"password\": \"smpProv@123\"}}}' "+endpoint+"/tokens";
		String cmd1 = "curl -m 5 -kv -H Content-Type:application/json -X POST -d '{\"auth\":{\"method\": \"password\",\"password\": {\"user_id\": \"smpProv\",\"password\": \"smpProv@123\"}}}' https://lme.oam.lab1.t-mobile.com:20443/v1/data/21-smpc-LAB1ESMLC/smpc/tokens";
				
		String cmd2 = "curl -X GET -k -H 'Accept: application/json' -H 'Content-Type: application/json' -H 'charset: UTF-8' -H \"X-Auth-Token: 841320b020e6eea61cb4a71d4707d73de7385701 \" -i https://lme.oam.lab1.t-mobile.com:20443/v1/data/21-smpc-LAB1ESMLC/smpc/cells/lte/cid_cells/310-260-256081810";

		System.out.println("Cmd1");
		System.out.println(cmd1);
		
		System.out.println("Cmd2");
		System.out.println(cmd2);
	}

}
