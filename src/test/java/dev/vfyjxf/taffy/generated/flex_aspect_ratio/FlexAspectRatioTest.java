package dev.vfyjxf.taffy.generated.flex_aspect_ratio;

import dev.vfyjxf.taffy.geometry.*;
import dev.vfyjxf.taffy.style.*;
import dev.vfyjxf.taffy.tree.*;
import dev.vfyjxf.taffy.util.MeasureFunc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Generated tests for flex_aspect_ratio layout fixtures.
 */
public class FlexAspectRatioTest {

    private static final float EPSILON = 0.1f;

    private static MeasureFunc ahemTextMeasure(String text, boolean vertical) {
        final String trimmed = text == null ? "" : text.trim();
        return (knownDimensions, availableSpace) -> {
            if (!Float.isNaN(knownDimensions.width) && !Float.isNaN(knownDimensions.height)) {
                return new FloatSize(knownDimensions.width, knownDimensions.height);
            }

            final char ZWS = '\u200B';
            final float H_WIDTH = 10.0f;
            final float H_HEIGHT = 10.0f;

            String[] parts = trimmed.isEmpty() ? new String[0] : trimmed.split(String.valueOf(ZWS), -1);
            if (parts.length == 0) {
                float w = !Float.isNaN(knownDimensions.width) ? knownDimensions.width : 0.0f;
                float h = !Float.isNaN(knownDimensions.height) ? knownDimensions.height : 0.0f;
                return new FloatSize(w, h);
            }

            int minLineLength = 0;
            int maxLineLength = 0;
            for (String p : parts) {
                int len = p.length();
                if (len > minLineLength) minLineLength = len;
                maxLineLength += len;
            }

            float knownInline = vertical ? knownDimensions.height : knownDimensions.width;
            float knownBlock = vertical ? knownDimensions.width : knownDimensions.height;
            AvailableSpace availInline = vertical ? availableSpace.height : availableSpace.width;

            float inlineSize;
            if (!Float.isNaN(knownInline)) {
                inlineSize = knownInline;
            } else if (availInline != null && availInline.isMinContent()) {
                inlineSize = minLineLength * H_WIDTH;
            } else if (availInline != null && availInline.isMaxContent()) {
                inlineSize = maxLineLength * H_WIDTH;
            } else if (availInline != null && availInline.isDefinite()) {
                inlineSize = Math.min(availInline.getValue(), maxLineLength * H_WIDTH);
            } else {
                inlineSize = maxLineLength * H_WIDTH;
            }
            inlineSize = Math.max(inlineSize, minLineLength * H_WIDTH);

            float blockSize;
            if (!Float.isNaN(knownBlock)) {
                blockSize = knownBlock;
            } else {
                int inlineLineLength = (int) Math.floor(inlineSize / H_WIDTH);
                int lineCount = 1;
                int currentLineLength = 0;
                for (String p : parts) {
                    int len = p.length();
                    if (currentLineLength + len > inlineLineLength) {
                        if (currentLineLength > 0) {
                            lineCount += 1;
                        }
                        currentLineLength = len;
                    } else {
                        currentLineLength += len;
                    }
                }
                blockSize = lineCount * H_HEIGHT;
            }

            FloatSize computed = vertical
                ? new FloatSize(blockSize, inlineSize)
                : new FloatSize(inlineSize, blockSize);

            float outW = !Float.isNaN(knownDimensions.width) ? knownDimensions.width : computed.width;
            float outH = !Float.isNaN(knownDimensions.height) ? knownDimensions.height : computed.height;
            return new FloatSize(outW, outH);
        };
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_001__border_box")
    void wptFlexAspectRatio001BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_001__content_box")
    void wptFlexAspectRatio001ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_002__border_box")
    void wptFlexAspectRatio002BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexBasis = TaffyDimension.length(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_002__content_box")
    void wptFlexAspectRatio002ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexBasis = TaffyDimension.length(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_003__border_box")
    void wptFlexAspectRatio003BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_003__content_box")
    void wptFlexAspectRatio003ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_004__border_box")
    void wptFlexAspectRatio004BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexBasis = TaffyDimension.length(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_004__content_box")
    void wptFlexAspectRatio004ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexBasis = TaffyDimension.length(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_005__border_box")
    void wptFlexAspectRatio005BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_005__content_box")
    void wptFlexAspectRatio005ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.boxSizing = BoxSizing.CONTENT_BOX;
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_006__border_box")
    void wptFlexAspectRatio006BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_006__content_box")
    void wptFlexAspectRatio006ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.boxSizing = BoxSizing.CONTENT_BOX;
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_007__border_box")
    void wptFlexAspectRatio007BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        nodeStyle.aspectRatio = 1.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_007__content_box")
    void wptFlexAspectRatio007ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.boxSizing = BoxSizing.CONTENT_BOX;
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        nodeStyle.aspectRatio = 1.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_008__border_box")
    void wptFlexAspectRatio008BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.aspectRatio = 1.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_008__content_box")
    void wptFlexAspectRatio008ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.boxSizing = BoxSizing.CONTENT_BOX;
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.aspectRatio = 1.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(50.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(50.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(50.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_009__border_box")
    void wptFlexAspectRatio009BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_009__content_box")
    void wptFlexAspectRatio009ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_010__border_box")
    void wptFlexAspectRatio010BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        node0Style.margin = new TaffyRect<>(LengthPercentageAuto.length(0.0f), LengthPercentageAuto.length(0.0f), LengthPercentageAuto.AUTO, LengthPercentageAuto.AUTO);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(50.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(100.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(0.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_010__content_box")
    void wptFlexAspectRatio010ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        node0Style.margin = new TaffyRect<>(LengthPercentageAuto.length(0.0f), LengthPercentageAuto.length(0.0f), LengthPercentageAuto.AUTO, LengthPercentageAuto.AUTO);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.boxSizing = BoxSizing.CONTENT_BOX;
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(100.0f));
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(50.0f, node0Layout.location().y, "y of node0");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(100.0f, node1Layout.size().width, "width of node1");
        assertEquals(100.0f, node1Layout.size().height, "height of node1");
        assertEquals(0.0f, node1Layout.location().x, "x of node1");
        assertEquals(0.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_011__border_box")
    void wptFlexAspectRatio011BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.percent(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_011__content_box")
    void wptFlexAspectRatio011ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.percent(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.length(50.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_012__border_box")
    void wptFlexAspectRatio012BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.length(50.0f);
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_012__content_box")
    void wptFlexAspectRatio012ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.length(50.0f);
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_013__border_box")
    void wptFlexAspectRatio013BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.percent(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(50.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(50.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_013__content_box")
    void wptFlexAspectRatio013ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.percent(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(50.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(50.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_014__border_box")
    void wptFlexAspectRatio014BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.length(50.0f);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_014__content_box")
    void wptFlexAspectRatio014ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.length(50.0f);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.flexWrap = FlexWrap.WRAP;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_019__border_box")
    void wptFlexAspectRatio019BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_019__content_box")
    void wptFlexAspectRatio019ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_020__border_box")
    void wptFlexAspectRatio020BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_020__content_box")
    void wptFlexAspectRatio020ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_021__border_box")
    void wptFlexAspectRatio021BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(20.0f), TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(20.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(20.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_021__content_box")
    void wptFlexAspectRatio021ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(20.0f), TaffyDimension.length(100.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(20.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(20.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_022__border_box")
    void wptFlexAspectRatio022BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexBasis = TaffyDimension.content();
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(20.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_022__content_box")
    void wptFlexAspectRatio022ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexBasis = TaffyDimension.content();
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(20.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_025__border_box")
    void wptFlexAspectRatio025BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(25.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 8.0f;
        node0Style.padding = new TaffyRect<>(LengthPercentage.length(10.0f), LengthPercentage.ZERO, LengthPercentage.length(15.0f), LengthPercentage.ZERO);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(200.0f, nodeLayout.size().width, "width of node");
        assertEquals(25.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(200.0f, node0Layout.size().width, "width of node0");
        assertEquals(25.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_025__content_box")
    void wptFlexAspectRatio025ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(25.0f));
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 8.0f;
        node0Style.padding = new TaffyRect<>(LengthPercentage.length(10.0f), LengthPercentage.ZERO, LengthPercentage.length(15.0f), LengthPercentage.ZERO);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(200.0f, nodeLayout.size().width, "width of node");
        assertEquals(25.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(200.0f, node0Layout.size().width, "width of node0");
        assertEquals(25.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_026__border_box")
    void wptFlexAspectRatio026BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(190.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(25.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 0.125f;
        node0Style.padding = new TaffyRect<>(LengthPercentage.length(15.0f), LengthPercentage.ZERO, LengthPercentage.length(10.0f), LengthPercentage.ZERO);
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(25.0f, nodeLayout.size().width, "width of node");
        assertEquals(200.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(25.0f, node0Layout.size().width, "width of node0");
        assertEquals(200.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(10.0f, node00Layout.size().width, "width of node00");
        assertEquals(190.0f, node00Layout.size().height, "height of node00");
        assertEquals(15.0f, node00Layout.location().x, "x of node00");
        assertEquals(10.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_026__content_box")
    void wptFlexAspectRatio026ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(190.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(25.0f), TaffyDimension.AUTO);
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 0.125f;
        node0Style.padding = new TaffyRect<>(LengthPercentage.length(15.0f), LengthPercentage.ZERO, LengthPercentage.length(10.0f), LengthPercentage.ZERO);
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(25.0f, nodeLayout.size().width, "width of node");
        assertEquals(200.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(25.0f, node0Layout.size().width, "width of node0");
        assertEquals(200.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(10.0f, node00Layout.size().width, "width of node00");
        assertEquals(190.0f, node00Layout.size().height, "height of node00");
        assertEquals(15.0f, node00Layout.location().x, "x of node00");
        assertEquals(10.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_031__border_box")
    void wptFlexAspectRatio031BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        node0Style.padding = new TaffyRect<>(LengthPercentage.length(100.0f), LengthPercentage.ZERO, LengthPercentage.ZERO, LengthPercentage.ZERO);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(50.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(50.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(50.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_031__content_box")
    void wptFlexAspectRatio031ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        node0Style.padding = new TaffyRect<>(LengthPercentage.length(100.0f), LengthPercentage.ZERO, LengthPercentage.ZERO, LengthPercentage.ZERO);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(50.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(50.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(50.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_032__border_box")
    void wptFlexAspectRatio032BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_032__content_box")
    void wptFlexAspectRatio032ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_033__border_box")
    void wptFlexAspectRatio033BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_033__content_box")
    void wptFlexAspectRatio033ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_034__border_box")
    void wptFlexAspectRatio034BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_034__content_box")
    void wptFlexAspectRatio034ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_035__border_box")
    void wptFlexAspectRatio035BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.display = TaffyDisplay.BLOCK;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_035__content_box")
    void wptFlexAspectRatio035ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.display = TaffyDisplay.BLOCK;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_036__border_box")
    void wptFlexAspectRatio036BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_036__content_box")
    void wptFlexAspectRatio036ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(0.0f, node0Layout.size().width, "width of node0");
        assertEquals(0.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_037__border_box")
    void wptFlexAspectRatio037BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_037__content_box")
    void wptFlexAspectRatio037ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(0.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_038__border_box")
    void wptFlexAspectRatio038BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(1.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 0.0f;
        node0Style.flexBasis = TaffyDimension.AUTO;
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.flexGrow = 1.0f;
        node1Style.flexShrink = 0.0f;
        node1Style.flexBasis = TaffyDimension.length(1.0f);
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(200.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(200.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(150.0f, node0Layout.size().width, "width of node0");
        assertEquals(150.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(1.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(0.0f, node1Layout.size().width, "width of node1");
        assertEquals(50.0f, node1Layout.size().height, "height of node1");
        assertEquals(0.0f, node1Layout.location().x, "x of node1");
        assertEquals(150.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_038__content_box")
    void wptFlexAspectRatio038ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(1.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 0.0f;
        node0Style.flexBasis = TaffyDimension.AUTO;
        node0Style.minSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle node1Style = new TaffyStyle();
        node1Style.boxSizing = BoxSizing.CONTENT_BOX;
        node1Style.direction = TaffyDirection.LTR;
        node1Style.display = TaffyDisplay.BLOCK;
        node1Style.flexGrow = 1.0f;
        node1Style.flexShrink = 0.0f;
        node1Style.flexBasis = TaffyDimension.length(1.0f);
        NodeId node1 = tree.newLeaf(node1Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.alignItems = AlignItems.START;
        nodeStyle.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(200.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0, node1);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(200.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(150.0f, node0Layout.size().width, "width of node0");
        assertEquals(150.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(1.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
        Layout node1Layout = tree.getLayout(node1);
        assertEquals(0.0f, node1Layout.size().width, "width of node1");
        assertEquals(50.0f, node1Layout.size().height, "height of node1");
        assertEquals(0.0f, node1Layout.location().x, "x of node1");
        assertEquals(150.0f, node1Layout.location().y, "y of node1");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_039__border_box")
    void wptFlexAspectRatio039BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(50.0f));
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(50.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(50.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_039__content_box")
    void wptFlexAspectRatio039ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.minSize = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(50.0f));
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(50.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(50.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_040__border_box")
    void wptFlexAspectRatio040BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_040__content_box")
    void wptFlexAspectRatio040ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_041__border_box")
    void wptFlexAspectRatio041BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 0.0f;
        node0Style.flexShrink = 0.0f;
        node0Style.flexBasis = TaffyDimension.AUTO;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_041__content_box")
    void wptFlexAspectRatio041ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 0.0f;
        node0Style.flexShrink = 0.0f;
        node0Style.flexBasis = TaffyDimension.AUTO;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.length(100.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_043__border_box")
    void wptFlexAspectRatio043BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.percent(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(200.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.maxSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(200.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_043__content_box")
    void wptFlexAspectRatio043ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 1.0f;
        node0Style.flexShrink = 1.0f;
        node0Style.flexBasis = TaffyDimension.percent(0.0f);
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(200.0f));
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.maxSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(200.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_044__border_box")
    void wptFlexAspectRatio044BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 0.0f;
        node0Style.flexShrink = 0.0f;
        node0Style.flexBasis = TaffyDimension.length(200.0f);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.maxSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(200.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_044__content_box")
    void wptFlexAspectRatio044ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.flexGrow = 0.0f;
        node0Style.flexShrink = 0.0f;
        node0Style.flexBasis = TaffyDimension.length(200.0f);
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        nodeStyle.maxSize = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        nodeStyle.aspectRatio = 2.0f;
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(200.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_045__border_box")
    void wptFlexAspectRatio045BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_045__content_box")
    void wptFlexAspectRatio045ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_046__border_box")
    void wptFlexAspectRatio046BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_046__content_box")
    void wptFlexAspectRatio046ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_047__border_box")
    void wptFlexAspectRatio047BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_047__content_box")
    void wptFlexAspectRatio047ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_048__border_box")
    void wptFlexAspectRatio048BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_048__content_box")
    void wptFlexAspectRatio048ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_049__border_box")
    void wptFlexAspectRatio049BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_049__content_box")
    void wptFlexAspectRatio049ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_050__border_box")
    void wptFlexAspectRatio050BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_050__content_box")
    void wptFlexAspectRatio050ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_051__border_box")
    void wptFlexAspectRatio051BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_051__content_box")
    void wptFlexAspectRatio051ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.AUTO);
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.percent(1.0f));
        node0Style.aspectRatio = 0.5f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(0.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_052__border_box")
    void wptFlexAspectRatio052BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_052__content_box")
    void wptFlexAspectRatio052ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node00Style = new TaffyStyle();
        node00Style.boxSizing = BoxSizing.CONTENT_BOX;
        node00Style.direction = TaffyDirection.LTR;
        node00Style.display = TaffyDisplay.BLOCK;
        node00Style.size = new TaffySize<>(TaffyDimension.AUTO, TaffyDimension.length(100.0f));
        NodeId node00 = tree.newLeaf(node00Style);

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.percent(1.0f), TaffyDimension.AUTO);
        node0Style.aspectRatio = 2.0f;
        NodeId node0 = tree.newWithChildren(node0Style, node00);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
        Layout node00Layout = tree.getLayout(node00);
        assertEquals(100.0f, node00Layout.size().width, "width of node00");
        assertEquals(100.0f, node00Layout.size().height, "height of node00");
        assertEquals(0.0f, node00Layout.location().x, "x of node00");
        assertEquals(0.0f, node00Layout.location().y, "y of node00");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_053__border_box")
    void wptFlexAspectRatio053BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_053__content_box")
    void wptFlexAspectRatio053ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.flexDirection = FlexDirection.COLUMN;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(0.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(100.0f, nodeLayout.size().width, "width of node");
        assertEquals(0.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_054__border_box")
    void wptFlexAspectRatio054BorderBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

    @Test
    @DisplayName("wpt_flex_aspect_ratio_054__content_box")
    void wptFlexAspectRatio054ContentBox() {
        TaffyTree tree = new TaffyTree();

        TaffyStyle node0Style = new TaffyStyle();
        node0Style.boxSizing = BoxSizing.CONTENT_BOX;
        node0Style.direction = TaffyDirection.LTR;
        node0Style.display = TaffyDisplay.BLOCK;
        node0Style.size = new TaffySize<>(TaffyDimension.length(100.0f), TaffyDimension.length(100.0f));
        node0Style.aspectRatio = 1.0f;
        NodeId node0 = tree.newLeaf(node0Style);

        TaffyStyle nodeStyle = new TaffyStyle();
        nodeStyle.boxSizing = BoxSizing.CONTENT_BOX;
        nodeStyle.direction = TaffyDirection.LTR;
        nodeStyle.size = new TaffySize<>(TaffyDimension.length(0.0f), TaffyDimension.length(100.0f));
        NodeId node = tree.newWithChildren(nodeStyle, node0);


        tree.computeLayout(node, TaffySize.maxContent());

        Layout nodeLayout = tree.getLayout(node);
        assertEquals(0.0f, nodeLayout.size().width, "width of node");
        assertEquals(100.0f, nodeLayout.size().height, "height of node");
        assertEquals(0.0f, nodeLayout.location().x, "x of node");
        assertEquals(0.0f, nodeLayout.location().y, "y of node");
        Layout node0Layout = tree.getLayout(node0);
        assertEquals(100.0f, node0Layout.size().width, "width of node0");
        assertEquals(100.0f, node0Layout.size().height, "height of node0");
        assertEquals(0.0f, node0Layout.location().x, "x of node0");
        assertEquals(0.0f, node0Layout.location().y, "y of node0");
    }

}
