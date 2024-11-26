package spring.io.hexagonal.adapter.in.web.v1.controller.common;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ApiResponse<T>(

	@JsonInclude(JsonInclude.Include.NON_NULL)
	T data,

	boolean success
) {

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<>(data, true);
	}

	public static <T> ApiResponse<T> failure(T data) {
		return new ApiResponse<>(data, false);
	}

}
