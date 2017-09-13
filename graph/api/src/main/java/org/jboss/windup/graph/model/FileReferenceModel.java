package org.jboss.windup.graph.model;

import org.jboss.windup.graph.model.resource.FileModel;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 * Isolated file reference interface from the other models.
 * 
 * @author <a href="mailto:mbriskar@gmail.com">Matej Briskar</a>
 *
 */
@TypeValue(FileReferenceModel.TYPE)
public interface FileReferenceModel extends WindupVertexFrame
{
    String TYPE = "FileReferenceModel";
    String FILE_MODEL = "file";

    /**
     * Contains the {@link FileModel} referenced by this object.
     */
    @Adjacency(label = FILE_MODEL, direction = Direction.OUT)
    FileModel getFile();

    /**
     * Contains the {@link FileModel} referenced by this object.
     */
    @Adjacency(label = FILE_MODEL, direction = Direction.OUT)
    FileModel setFile(FileModel file);
}
