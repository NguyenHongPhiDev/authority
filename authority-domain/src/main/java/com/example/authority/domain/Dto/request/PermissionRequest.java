package com.example.authority.domain.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionRequest {
   private String user_id;
   private String permission_id;
}
