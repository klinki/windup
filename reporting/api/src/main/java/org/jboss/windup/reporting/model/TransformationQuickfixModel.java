package org.jboss.windup.reporting.model;

import org.jboss.windup.graph.model.resource.FileModel;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 * This contains information for a quickfix that will use a custom transformer class.
 *
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
@TypeValue(TransformationQuickfixModel.TYPE)
public interface TransformationQuickfixModel extends QuickfixModel
{
    String TYPE = "TransformationQuickfixModel";

    String TRANSFORMATION_ID = TYPE + "-transformationID";
    String FILE = TYPE + "-file";

    /**
     * Contains the ID of the class that will implement this translation.
     */
    @Property(TRANSFORMATION_ID)
    String getTransformationID();

    /**
     * Contains the ID of the class that will implement this translation.
     */
    @Property(TRANSFORMATION_ID)
    void setTransformationID(String transformationID);

    /**
     * Contains the file associated with this quickfix.
     */
    @Adjacency(label = FILE, direction = Direction.OUT)
    FileModel getFile();

    /**
     * Contains the file associated with this quickfix.
     */
    @Adjacency(label = FILE, direction = Direction.OUT)
    FileModel setFileModel(FileModel fileModel);
}
