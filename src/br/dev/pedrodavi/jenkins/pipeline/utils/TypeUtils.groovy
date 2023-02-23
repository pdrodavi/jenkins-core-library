package br.dev.pedrodavi.jenkins.pipeline.utils

import br.dev.pedrodavi.jenkins.pipeline.utils.maps.MapMergeMode
import br.dev.pedrodavi.jenkins.pipeline.versioning.ComparableVersion
import com.cloudbees.groovy.cps.NonCPS

class TypeUtils implements Serializable {

    private static final long serialVersionUID = 1L

    /**
     * Utility function to return false for all non Map objects
     *
     * @param object Any other object that is not of type Map
     * @return false
     */
    @NonCPS
    Boolean isMap(Object object) {
        return false
    }

    /**
     * Utility function to return true for all Map objects
     *
     * @param object Map object
     * @return true
     */
    @NonCPS
    Boolean isMap(Map object) {
        return true
    }

    /**
     * Utility function to return true for all MapMergeMode objects
     *
     * @param mode MapMergeMode object
     * @return true
     */
    @NonCPS
    isMapMergeMode(MapMergeMode mode) {
        return true
    }

    /**
     * Utility function to return false for all non MapMergeMode objects
     *
     * @param object Non MapMergeMode object
     * @return false
     */
    @NonCPS
    isMapMergeMode(Object mode) {
        return false
    }

    /**
     * Utility function to return false for all non List objects
     *
     * @param object Any other object that is not of type List
     * @return false
     */
    @NonCPS
    Boolean isList(Object object) {
        return false
    }

    /**
     * Utility function to return true for all List objects
     *
     * @param object List object
     * @return true
     */
    @NonCPS
    Boolean isList(List object) {
        return true
    }

    /**
     * Utility function to return false for all non Closure objects
     *
     * @param object Any other object that is not of type Closure
     * @return false
     */
    @NonCPS
    Boolean isClosure(Object object) {
        return false
    }

    /**
     * Utility function to return true for all Closure objects
     *
     * @param object Closure object
     * @return true
     */
    @NonCPS
    Boolean isClosure(Closure object) {
        return true
    }

    /**
     * Utility function to return false for all non ListItem objects
     *
     * @param object Comparable Version object
     * @return true
     */
    @NonCPS
    Boolean isComparableVersion(ComparableVersion object) {
        return true
    }

    /**
     * Utility function to return false for all non ComparableVersion objects
     *
     * @param object Any other object that is not of type ComparableVersion
     * @return false
     */
    @NonCPS
    Boolean isComparableVersion(Object object) {
        return false
    }

}
