package com.example.demo.account.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {
    @NonNull
    private String name;
    @NonNull
    private String level;
}
