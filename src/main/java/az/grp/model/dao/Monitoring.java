package az.grp.model.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Seymur on 14.07.2016.
 */

@Entity
@Table(name = "monitoring")
public class Monitoring implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Groups groups;

    @Column(name = "deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "number")
    private Integer number;

}
