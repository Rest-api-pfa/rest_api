/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Resources;

import Model.Client;
import Model.Cmd;
import Services.CmdService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author drging
 */
@Path("command")
public class CmdResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cmd> getCmds()
    {
        return CmdService.getCmds();
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{CmdId}")
    public Cmd getCmd(@PathParam("CmdId") int id)
    {
        return CmdService.getCmd(id);  
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{CmdId}/client")
    public Client getClientsRes(@PathParam("CmdId") int id)
    {
        return CmdService.getCmd_client(id);
    }
}
