package org.jboss.windup.reporting.model;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.modules.javahandler.JavaHandler;
import com.tinkerpop.frames.modules.javahandler.JavaHandlerContext;
import com.tinkerpop.frames.modules.typedgraph.TypeValue;
import org.jboss.windup.graph.Indexed;
import org.jboss.windup.graph.model.ToFileModelTransformable;
import org.jboss.windup.graph.model.resource.FileModel;
import org.jboss.windup.reporting.model.association.LinkableModel;
import org.ocpsoft.rewrite.config.Rule;

import static org.jboss.windup.reporting.model.InlineHintModel.ISSUE_DISPLAY_MODE;

/**
 * This classifies files and provides general background information about a specific {@link FileModel}. (For instance,
 * an XML file may be classified as a "XYZ Configuration File".) A {@link ClassificationModel} may also contain links to
 * additional information, or auto-translated/generated/updated versions of the source file.
 */
@TypeValue(ClassificationModel.TYPE)
public interface ClassificationModel extends EffortReportModel, LinkableModel, ToFileModelTransformable, TaggableModel
{
    String TYPE = "ClassificationModel";
    String TYPE_PREFIX = TYPE + "-";
    String RULE_ID = TYPE_PREFIX + "ruleID";
    String CLASSIFICATION = TYPE_PREFIX + "classification";
    String DESCRIPTION = TYPE_PREFIX + "description";

    String FILE_MODEL = TYPE_PREFIX + "classificationModelToFileModel";
    String QUICKFIXES = TYPE_PREFIX + "quickfixes";

    /**
     * Add a {@link FileModel} associated with this {@link ClassificationModel}.
     */
    @Adjacency(label = FILE_MODEL, direction = Direction.OUT)
    void addFileModel(FileModel fileModel);

    /**
     * Get the {@link FileModel} associated with this {@link ClassificationModel}.
     */
    @Adjacency(label = FILE_MODEL, direction = Direction.OUT)
    Iterable<FileModel> getFileModels();

    /**
     * Set text of this {@link ClassificationModel}.
     */
    @Indexed
    @Property(CLASSIFICATION)
    void setClassification(String classification);

    /**
     * Get text of this {@link ClassificationModel}.
     */
    @Property(CLASSIFICATION)
    String getClassification();

    /**
     * Contains an indicator as to which reports should display this issue. See also {@link IssueDisplayMode}.
     */
    @Property(ISSUE_DISPLAY_MODE)
    void setIssueDisplayMode(IssueDisplayMode issueDisplayMode);

    /**
     * Contains an indicator as to which reports should display this issue. See also {@link IssueDisplayMode}.
     */
    @Property(ISSUE_DISPLAY_MODE)
    IssueDisplayMode getIssueDisplayMode();

    /**
     * Set the description text of this {@link ClassificationModel}.
     */
    @Property(DESCRIPTION)
    void setDescription(String description);

    /**
     * Get the description text of this {@link ClassificationModel}.
     */
    @Property(DESCRIPTION)
    String getDescription();

    /**
     * Set ID of the {@link Rule} that added this {@link ClassificationModel}.
     */
    @Property(RULE_ID)
    void setRuleID(String ruleID);

    /**
     * Get ID of the {@link Rule} that added this {@link ClassificationModel}.
     */
    @Property(RULE_ID)
    String getRuleID();

    @Adjacency(label = QUICKFIXES, direction = Direction.OUT)
    void addQuickfix(QuickfixModel quickfixModel);

    @Adjacency(label = QUICKFIXES, direction = Direction.OUT)
    Iterable<QuickfixModel> getQuickfixes();

    @JavaHandler
    @Override
    Iterable<FileModel> transformToFileModel();

    abstract class Impl implements ClassificationModel, JavaHandlerContext<Vertex>
    {
        @Override
        public Iterable<FileModel> transformToFileModel() {
            return this.getFileModels();
        }
    }

}
