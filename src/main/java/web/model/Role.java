package web.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

//    @Column(name = "users")
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;

    public Role(String role) {
        this.role = role;
    }



    @Override
    public String getAuthority() {
        return role;
    }

//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", role='" + role + '\'' +
//                '}';
//    }
}
