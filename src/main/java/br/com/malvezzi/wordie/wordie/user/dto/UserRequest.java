package br.com.malvezzi.wordie.wordie.user.dto;

public record UserRequest(
  String firebaseUid,
  String name,
  String email
) {}
