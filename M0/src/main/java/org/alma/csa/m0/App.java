package org.alma.csa.m0;

import org.alma.csa.m1.client.Client;
import org.alma.csa.m1.client.SendRequest;
import org.alma.csa.m1.connector.glue.RPCGlue;
import org.alma.csa.m1.connector.glue.RPCGluePortCalled;
import org.alma.csa.m1.connector.glue.RPCGluePortCaller;
import org.alma.csa.m1.rpc.RPC;
import org.alma.csa.m1.rpc.RPCInternalRoleCalled;
import org.alma.csa.m1.rpc.RPCInternalRoleCaller;
import org.alma.csa.m1.rpc.RPCRoleCalled;
import org.alma.csa.m1.rpc.RPCRoleCaller;
import org.alma.csa.m1.server.ReceiveRequest;
import org.alma.csa.m1.server.Server;
import org.alma.csa.m1.system.System;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	////////////
    	// Client //
    	////////////
    	
    	
    	Client client = new Client();
    	SendRequest sendRequest = new SendRequest();
    	client.addPorts(sendRequest);
    	sendRequest.transfer("lol");
    	
    	/////////
    	// RPC //
    	/////////
    	
    	RPC rpc = new RPC();
    	RPCRoleCaller rpcRoleCaller = new RPCRoleCaller();
    	RPCRoleCalled rpcRoleCalled = new RPCRoleCalled();
    
    	rpc.addRoles(rpcRoleCaller,rpcRoleCalled);
    	
    	RPCInternalRoleCaller rpcInternalRoleCaller = new RPCInternalRoleCaller();
    	RPCInternalRoleCalled rpcInternalRoleCalled = new RPCInternalRoleCalled();
    	
    	rpc.addInternalRoles(rpcInternalRoleCaller,rpcInternalRoleCalled);
    	
    	RPCGlue rpcGlue = new RPCGlue();
    	RPCGluePortCaller rpcGluePortCaller = new RPCGluePortCaller();
    	RPCGluePortCalled rpcGluePortCalled = new RPCGluePortCalled();
    	rpcGlue.addPorts(rpcGluePortCalled, rpcGluePortCaller);
    	
    	rpcGluePortCalled.setRole(rpcInternalRoleCalled);
    	rpcGluePortCaller.setRole(rpcInternalRoleCaller);
    	rpcInternalRoleCalled.setPort(rpcGluePortCalled);
    	rpcInternalRoleCaller.setPort(rpcGluePortCaller);
    	
    	//Binding RPC - Client
    	rpcRoleCaller.setPort(sendRequest);
    	sendRequest.setRole(rpcRoleCaller);
    	
    	////////////
    	// Server //
    	////////////

    	Server server = new Server();
    	ReceiveRequest receiveRequest = new ReceiveRequest();
    	server.addPorts(receiveRequest);
    	
    	
    	/////////////
    	// Système //
    	/////////////
    	
        System sys = new System();
        
        sys.addComposite(client);
        sys.addComposite(server);
    }
}
