package ai.api.examples.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/***********************************************************************************************************************
 *
 * API.AI Java SDK - client-side libraries for API.AI
 * =================================================
 *
 * Copyright (C) 2017 by Speaktoit, Inc. (https://www.speaktoit.com)
 * https://www.api.ai
 *
 ***********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 ***********************************************************************************************************************/

import javax.servlet.annotation.WebServlet;

import ai.api.model.AIOutputContext;
import ai.api.model.Fulfillment;
import ai.api.model.ResponseMessage;
import ai.api.model.ResponseMessage.ResponseSpeech;
import ai.api.web.AIWebhookServlet;
import api.consumer.common.Commons;
import api.consumer.service.CTPServiceAction;

@WebServlet("/webhook")
public class WebhookSample extends AIWebhookServlet {
	private static final long serialVersionUID = 1L;
	//private static JedisPool pool = null;

	@Override
	protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
		/*pool = new JedisPool(new JedisPoolConfig(), "localhost", 6379,10*1000);
		Jedis jedis = null;
		String value = "";
		jedis = pool.getResource();*/
		//input.getSessionId()
		/*String action=input.getResult().getAction();
		try {
			if(action.equals("PolicyNumberValidation")){
			System.out.println("input request --Query param :$$$$$$$$$: "+input);
			String serviceResp = null;
			String policyNoJSON = input.getResult().getParameters().get("PolicyNumber").toString();
			System.out.println("parameter value:"+policyNoJSON);
			Map responsejson = Commons.getGsonData(policyNoJSON);
			String policyNumber=(String)responsejson.get("Given-PolicyNumber");
			policyNumber =policyNumber.replaceAll("\"", "");
			System.out.println("Policy Number is: " + policyNumber);
			CTPServiceAction ctpserviceAction = new CTPServiceAction();
			
			serviceResp = ctpserviceAction.getOTP(policyNumber); */
			/*String cacheKey = getCacheKey (policyNo);
	        value = jedis.get(cacheKey);
	        if (value == null) {
	        	jedis.set(cacheKey, serviceResp);
	        }
	        else{
	        	System.out.println("OTP-************"+value);	        	
	        }*/
			/*System.out.println("OTP-************"+serviceResp);
			List<AIOutputContext> outlist=input.getResult().getContexts();
			for (AIOutputContext object : outlist) {
				Iterator itr=object.getParameters().keySet().iterator();
				while(itr.hasNext()){
					String name=itr.next().toString();
					System.out.println("contextvariable++++++"+name);
					if(name.equals("SYSOTP")){
						System.out.println("PPPPPPPPPPPPP"+object.getParameters().get("SYSOTP"));
					}
				}
			}*/
				/*System.out.println("Setting speech now");
				
			output.setSpeech("Hello");
			output.setDisplayText("hello");
			*/
			/*	AIOutputContext aiout=new AIOutputContext();
			String str="{\"CACHEOTP\": \""+serviceResp+"\"}";
			aiout.setName("CACHEOTP");
			aiout.setParameters(Commons.getGsonData1(str));
			output.setContextOut(aiout);
			Map map=new HashMap();
			output.setData(map);*/
			/*output.setSource("PolicyNumberValidation");
				System.out.println("Have set everything includong context"); */
			/*ResponseSpeech rm=new ResponseSpeech();
			rm.setSpeech("OTP is sent to your Registered Mobile Number. Please provide your OTP for verification");
			output.setMessages(rm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		output.setSpeech("You said: " + input.getResult().getFulfillment().getSpeech());
	}
	protected String getCacheKey (String policyNum) {
        String cacheKey = policyNum +"_OTP";
        return cacheKey;
    }
}



