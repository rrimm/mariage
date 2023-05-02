package com.multi.mariage.storage.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class StorageControllerTest extends ControllerTest {

    private static final MockMultipartFile IMAGE = ImageFixture.JPEG_IMAGE.toMultipartFile();

    @DisplayName("이미지를 저장한다.")
    @Test
    void 이미지를_저장한다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/user/image")
                        .file(IMAGE))
                .andDo(MockMvcResultHandlers.print())
                .andDo(
                        MockMvcRestDocumentation.document("ImageUpload",
                                Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                                Preprocessors.preprocessResponse(Preprocessors.prettyPrint()),
                                RequestDocumentation.requestParts(
                                        RequestDocumentation.partWithName("file").description("업로드를 원하는 이미지")),
                                PayloadDocumentation.responseFields(
                                        PayloadDocumentation.fieldWithPath("imageId").description("이미지 식별자")
                                )
                        )
                )
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}