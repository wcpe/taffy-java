package dev.vfyjxf.taffy.tree;

import dev.vfyjxf.taffy.geometry.FloatSize;
import dev.vfyjxf.taffy.geometry.TaffyLine;
import dev.vfyjxf.taffy.geometry.TaffySize;
import dev.vfyjxf.taffy.style.AvailableSpace;

import java.util.Objects;

/**
 * A struct containing the input constraints/hints for laying out a node, which are passed in by the parent.
 *
 * @param runMode                       Whether we only need to know the Node's size, or whether we need to perform a full layout
 * @param sizingMode                    Whether a Node's style sizes should be taken into account or ignored
 * @param axis                          Which axis we need the size of
 * @param knownDimensions               Known dimensions represent dimensions (width/height) which should be taken as fixed when performing layout.
 * @param parentSize                    Parent size dimensions are intended to be used for percentage resolution.
 * @param availableSpace                Available space represents an amount of space to layout into, and is used as a soft constraint for wrapping.
 * @param verticalMarginsAreCollapsible Specific to CSS Block layout. Used for correctly computing margin collapsing.
 */
public final class LayoutInput {

    private final RunMode runMode;
    private final SizingMode sizingMode;
    private final RequestedAxis axis;
    private final FloatSize knownDimensions;
    private final FloatSize parentSize;
    private final TaffySize<AvailableSpace> availableSpace;
    private final TaffyLine<Boolean> verticalMarginsAreCollapsible;

    public LayoutInput(
        RunMode runMode,
        SizingMode sizingMode,
        RequestedAxis axis,
        FloatSize knownDimensions,
        FloatSize parentSize,
        TaffySize<AvailableSpace> availableSpace,
        TaffyLine<Boolean> verticalMarginsAreCollapsible
    ) {
        this.runMode = runMode;
        this.sizingMode = sizingMode;
        this.axis = axis;
        this.knownDimensions = knownDimensions;
        this.parentSize = parentSize;
        this.availableSpace = availableSpace;
        this.verticalMarginsAreCollapsible = verticalMarginsAreCollapsible;
    }

    public RunMode runMode() {
        return runMode;
    }

    public SizingMode sizingMode() {
        return sizingMode;
    }

    public RequestedAxis axis() {
        return axis;
    }

    public FloatSize knownDimensions() {
        return knownDimensions;
    }

    public FloatSize parentSize() {
        return parentSize;
    }

    public TaffySize<AvailableSpace> availableSpace() {
        return availableSpace;
    }

    public TaffyLine<Boolean> verticalMarginsAreCollapsible() {
        return verticalMarginsAreCollapsible;
    }

    /**
     * Create a LayoutInput for hidden layout
     */
    public static final LayoutInput HIDDEN = new LayoutInput(
        RunMode.PERFORM_HIDDEN_LAYOUT,
        SizingMode.INHERENT_SIZE,
        RequestedAxis.BOTH,
        FloatSize.none(),
        FloatSize.none(),
        new TaffySize<>(AvailableSpace.MAX_CONTENT, AvailableSpace.MAX_CONTENT),
        TaffyLine.FALSE
    );

    /**
     * Static factory method for hidden layout input
     */
    public static LayoutInput hidden() {
        return HIDDEN;
    }

    // === Getters ===

    /**
     * Create a copy with modified knownDimensions
     */
    public LayoutInput withKnownDimensions(FloatSize knownDimensions) {
        return new LayoutInput(
            this.runMode,
            this.sizingMode,
            this.axis,
            knownDimensions,
            this.parentSize,
            this.availableSpace,
            this.verticalMarginsAreCollapsible
        );
    }

    /**
     * Create a copy with modified availableSpace
     */
    public LayoutInput withAvailableSpace(TaffySize<AvailableSpace> availableSpace) {
        return new LayoutInput(
            this.runMode,
            this.sizingMode,
            this.axis,
            this.knownDimensions,
            this.parentSize,
            availableSpace,
            this.verticalMarginsAreCollapsible
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LayoutInput that = (LayoutInput) o;
        return Objects.equals(runMode, that.runMode)
            && Objects.equals(sizingMode, that.sizingMode)
            && Objects.equals(axis, that.axis)
            && Objects.equals(knownDimensions, that.knownDimensions)
            && Objects.equals(parentSize, that.parentSize)
            && Objects.equals(availableSpace, that.availableSpace)
            && Objects.equals(verticalMarginsAreCollapsible, that.verticalMarginsAreCollapsible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runMode, sizingMode, axis, knownDimensions, parentSize, availableSpace, verticalMarginsAreCollapsible);
    }

    @Override
    public String toString() {
        return "LayoutInput{runMode=" + runMode + ", knownDimensions=" + knownDimensions +
               ", availableSpace=" + availableSpace + "}";
    }
}
