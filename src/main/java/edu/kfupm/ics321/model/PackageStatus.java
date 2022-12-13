package edu.kfupm.ics321.model;

import java.util.*;
import java.util.Set;
import javax.persistence.*;

public enum PackageStatus {
    PROCESSING,
    READY,
    IN_TRANSIT,
    DELIVERED,
    LOST,
    DAMAGED,
    DELAYED;

    private PackageStatus() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
