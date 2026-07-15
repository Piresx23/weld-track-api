package pt.weldtrack.weld.track_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pt.weldtrack.weld.track_api.model.SoldadorEntity;
import pt.weldtrack.weld.track_api.repository.SoldadorRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SoldadorRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SoldadorEntity soldador = repository.findBySoldadorName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilizador não encontrado"));

        return User.builder()
                .username(soldador.getSoldadorName())
                .password(soldador.getPassword())
                .roles(soldador.getPapel())
                .build();
    }
}