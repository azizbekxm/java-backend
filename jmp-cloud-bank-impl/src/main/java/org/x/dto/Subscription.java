package org.x.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
  private Long id;
  private String name;
  private String description;
  private Double price;
  private Boolean active;
}
