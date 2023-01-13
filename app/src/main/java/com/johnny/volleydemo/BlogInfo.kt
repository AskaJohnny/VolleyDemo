package com.johnny.volleydemo

data class BlogInfo(
    val code: Int,
    val `data`: Data,
    val msg: String
)

data class Data(
    val anchors: List<Anchor>,
    val blogContent: String,
    val blogImageUrl: String,
    val blogMdContent: String,
    val blogShortContent: String,
    val blogTitle: String,
    val blogTypeAnchor: Any,
    val blogTypeId: String,
    val blogTypeName: Any,
    val clickCount: Int,
    val createDate: String,
    val createMonth: Any,
    val createTime: String,
    val createUser: Any,
    val id: Int,
    val isThumbed: String,
    val nextBlogId: Any,
    val nextBlogTitle: Any,
    val previousBlogId: Any,
    val previousBlogTitle: Any,
    val thumbCount: Int,
    val updateTime: String
)

data class Anchor(
    val anchorId: String,
    val anchorName: String
)