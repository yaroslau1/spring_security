package web.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "role")
    @Getter
    @Setter
    private String role;

    @Column(name = "users")
    @ManyToMany(mappedBy = "roles")
    @Getter
    @Setter
    private Set<User> users;

    @Override
    public String getAuthority() {
        return role;
    }
}
