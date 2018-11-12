/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Resources;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author drging
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Resources.ClientResource.class);
        resources.add(Resources.CmdResource.class);
        resources.add(Resources.GenericResource.class);
        resources.add(Resources.LivreResource.class);
        resources.add(Resources.ProduitResource.class);
    }
    
}
