package toeatlist.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    private @Id @GeneratedValue Long userId;
    private @NonNull String login;
    private @NonNull String password;

    /*
     * public @NonNull Integer weight;
     * public @NonNull Integer height;
     * public @NonNull Integer age;
     * public @NonNull String gender;
     */
}