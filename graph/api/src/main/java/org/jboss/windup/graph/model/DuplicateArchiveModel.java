package org.jboss.windup.graph.model;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;

/**
 * Indicates that this {@link ArchiveModel} is actually a duplicate of another archive. This will be linked
 * back to the canonical archive.
 *
 * The duplicate will generally contain no files and the canonical archive ({@see DuplicateArchiveModel#getCanonicalArchive})
 * should be used for finding the included files.
 *
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
@TypeValue(DuplicateArchiveModel.TYPE)
public interface DuplicateArchiveModel extends ArchiveModel
{
    String TYPE = "DuplicateArchiveModel";

    String CANONICAL_ARCHIVE = TYPE + "-canonicalArchive";

    /**
     * Contains a link to the canonical archive from this duplicate instance.
     */
    @Adjacency(label = CANONICAL_ARCHIVE, direction = Direction.OUT)
    ArchiveModel getCanonicalArchive();

    /**
     * Contains a link to the canonical archive from this duplicate instance.
     */
    @Adjacency(label = CANONICAL_ARCHIVE, direction = Direction.OUT)
    DuplicateArchiveModel setCanonicalArchive(ArchiveModel original);
}
