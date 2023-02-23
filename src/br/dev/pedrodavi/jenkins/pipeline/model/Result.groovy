package br.dev.pedrodavi.jenkins.pipeline.model

import com.cloudbees.groovy.cps.NonCPS
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings
import hudson.model.Result as HudsonResult

@SuppressFBWarnings('ME_ENUM_FIELD_SETTER')
enum Result {

    NOT_BUILT(HudsonResult.NOT_BUILT, 3, '#9d9d9d'),
    ABORTED(HudsonResult.ABORTED, 4, '#515151'),
    FAILURE(HudsonResult.FAILURE, 2, '#f0372e'),
    UNSTABLE(HudsonResult.UNSTABLE, 1, '#ffb93e'),
    SUCCESS(HudsonResult.SUCCESS, 0,'#63a80e'),
    STILL_FAILING(HudsonResult.FAILURE, "STILL FAILING", 2,'#f0372e'),
    STILL_UNSTABLE(HudsonResult.UNSTABLE, "STILL UNSTABLE", 1,'#ffb93e'),
    FIXED(HudsonResult.SUCCESS, "FIXED", 0,'#63a80e'),
    // NOT_BUILD is deprecated due to a typo error
    NOT_BUILD(hudson.model.Result.NOT_BUILT, 3, '#9d9d9d')

    HudsonResult hudsonResult

    String name

    Integer ordinal

    String color

    Result(HudsonResult r, String name, Integer ordinal, String color) {
        this.hudsonResult = r
        this.name = name
        this.ordinal = ordinal
        this.color = color
    }

    Result(HudsonResult r, Integer ordinal, String color) {
        this(r, r.toString(), ordinal, color)
    }

    @NonCPS
    static Result fromString(String s) {
        if (s == null) return null
        for (r in values()) {
            if (s.equalsIgnoreCase(r.toString())) return r
        }

        return FAILURE
    }

    @NonCPS
    @Override
    String toString() {
        return name
    }

    @NonCPS
    boolean isWorseThan(Result that) {
        return this.ordinal > that.ordinal
    }

    @NonCPS
    boolean isWorseOrEqualTo(Result that) {
        return this.ordinal >= that.ordinal
    }

    @NonCPS
    boolean isBetterThan(Result that) {
        return this.ordinal < that.ordinal
    }

    @NonCPS
    boolean isBetterOrEqualTo(that) {
        return this.ordinal <= that.ordinal
    }

}