package com.spodin.v.graphql.demo.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class McRewards {

    @Column(name = "mcr_points")
    private Long points;

    @Column(name = "mcr_status")
    @Enumerated(EnumType.STRING)
    private McRewardsStatus status;

    public McRewards() {
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public McRewardsStatus getStatus() {
        return status;
    }

    public void setStatus(McRewardsStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MastercardRewards{" +
            "points=" + points +
            ", status=" + status +
            '}';
    }
}
