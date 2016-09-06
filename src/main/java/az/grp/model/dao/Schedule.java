package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 14.07.2016.
 */

@Entity
@Table(name = "schedule")
public class Schedule implements IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Groups groups;
    /*@ManyToOne
    @JoinColumn(name = "sub_lesson_id", referencedColumnName = "id")
    private SubLesson subLesson;*/
    @Column(name = "start_time")
    private Integer startTime;
    @Column(name = "end_time")
    private Integer endTime;
    @Column(name = "day")
    private Integer day;
    @Column(name = "room")
    private String room;
    @Column(name = "week_type")
    private int weekType;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;



    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getWeekType() {
        return weekType;
    }

    public void setWeekType(int weekType) {
        this.weekType = weekType;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

   /* public SubLesson getSubLesson() {
        return subLesson;
    }

    public void setSubLesson(SubLesson subLesson) {
        this.subLesson = subLesson;
    }*/

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groups=" + groups +
              /*  ", subLesson=" + subLesson +*/
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", day=" + day +
                ", room='" + room + '\'' +
                ", weekType=" + weekType +
                ", created=" + created +
                '}';
    }
}
