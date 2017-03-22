package ai.api.examples.web;

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

import ai.api.model.Fulfillment;
import ai.api.web.AIWebhookServlet;

@WebServlet("/webhook")
public class WebhookSample extends AIWebhookServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
		try {
			System.out.println("input request --Query param :$$$$$$$$$"+input);
			String serviceResp = null;
//			input.getResult().getParameters().get("query");
			String policyNo = input.getResult().getParameters().get("query").toString();
			System.out.println("input request --Query param :$$$$$$$$$"+input.getResult().getParameters().get("query").toString());
			CTPServiceAction ctpserviceAction = new CTPServiceAction();
			serviceResp = ctpserviceAction.processRequest(policyNo);			
			output.setSpeech("premium due is: " + serviceResp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

