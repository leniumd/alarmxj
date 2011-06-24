/**
 * Copyright 2011 Micheal Swiggs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.bitcoin.core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.net.InetSocketAddress;

public class SeedPeersTest {
	@Test
	public void getPeer_one() throws Exception{
		SeedPeers seedPeers = new SeedPeers(NetworkParameters.prodNet());
		assertThat(seedPeers.getPeer(), notNullValue());
	}
	
	@Test
	public void getPeer_all() throws Exception{
		SeedPeers seedPeers = new SeedPeers(NetworkParameters.prodNet());
		for(int i = 0; i < SeedPeers.seedAddrs.length; ++i){
			assertThat("Failed on index: "+i, seedPeers.getPeer(), notNullValue());
		}
		assertThat(seedPeers.getPeer(), equalTo(null));
	}
	
	@Test
	public void getPeers_length() throws Exception{
		SeedPeers seedPeers = new SeedPeers(NetworkParameters.prodNet());
		InetSocketAddress[] addresses = seedPeers.getPeers();
		assertThat(addresses.length, equalTo(SeedPeers.seedAddrs.length));
	}
}