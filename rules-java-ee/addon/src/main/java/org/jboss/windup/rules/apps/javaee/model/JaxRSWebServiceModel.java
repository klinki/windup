package org.jboss.windup.rules.apps.javaee.model;

import org.jboss.windup.graph.Indexed;
import org.jboss.windup.rules.apps.java.model.JavaClassModel;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 * JaxRS REST Web Service.
 * 
 * @author <a href="mailto:bradsdavis@gmail.com">Brad Davis</a>
 */
@TypeValue(JaxRSWebServiceModel.TYPE)
public interface JaxRSWebServiceModel extends WebServiceModel
{
    String TYPE = "JaxRSWebServiceModel";
    String JAXRS_IMPLEMENTATION_CLASS = "jaxrsImplementationClass";
    String JAXRS_INTERFACE = "jaxrsInterface";
    
    String PATH = "jaxrsPath";
    

    /**
     * Contains the URL path to the JaxRS service.
     */
    @Property(PATH)
    @Indexed
    String getPath();

    /**
     * Contains the URL path to the JaxRS service.
     */
    @Property(PATH)
    void setPath(String packageName);
    
    /**
     * Contains the JAX-RS implementation class
     */
    @Adjacency(label = JAXRS_IMPLEMENTATION_CLASS, direction = Direction.OUT)
    void setImplementationClass(JavaClassModel implRef);

    /**
     * Contains the JAX-RS implementation class
     */
    @Adjacency(label = JAXRS_IMPLEMENTATION_CLASS, direction = Direction.OUT)
    JavaClassModel getImplementationClass();

    /**
     * Contains the JAX-RS implementation class
     */
    @Adjacency(label = JAXRS_INTERFACE, direction = Direction.OUT)
    void setInterface(JavaClassModel interfaceRef);

    /**
     * Contains the JAX-RS implementation class
     */
    @Adjacency(label = JAXRS_INTERFACE, direction = Direction.OUT)
    JavaClassModel getInterface();
}
