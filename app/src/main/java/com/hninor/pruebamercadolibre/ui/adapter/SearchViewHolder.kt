package com.hninor.pruebamercadolibre.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hninor.pruebamercadolibre.MercadoLibreApplication
import com.hninor.pruebamercadolibre.databinding.LayoutSearchItemBinding
import com.hninor.pruebamercadolibre.repository.entities.Result

class SearchViewHolder(private val binding: LayoutSearchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        //setupCommentsView(binding.rvComments)
        //addTweetImagesView()
    }

    //private lateinit var imagesAdapter: ImagesAdapter
    //private lateinit var commentsAdapter: CommentsAdapter
    private var imageLoader = MercadoLibreApplication.imageLoader
    fun bind(tweet: Result) {
        //renderSender(tweet.sender)
        //renderTextContent(tweet.content)
        //renderImages(tweet.images)
        //commentsAdapter.comments = tweet.comments

    }

/*    private fun renderSender(sender: Sender?) {
        binding.tvSenderNickname.text = sender?.nick
        imageLoader.displayImage(sender?.avatar, binding.ivSenderAvatar)
    }*/

    private fun renderTextContent(content: String?) {
        binding.tvTweetContent.text = content
    }

/*    private fun renderImages(imagesBean: List<ImagesBean>?) {
        if (imagesBean == null || imagesBean.isEmpty()) {
            binding.simpleImageView.visibility = View.GONE
            binding.imagesRecyclerView.visibility = View.GONE
            return
        }
        binding.imagesRecyclerView.layoutManager = if (imagesBean.size == 4) {
            GridLayoutManager(itemView.context, 2, RecyclerView.HORIZONTAL, false)
        } else {
            GridLayoutManager(itemView.context, IMAGE_SPAN_COUNT, RecyclerView.VERTICAL, false)
        }

        if (imagesBean.size == 1) {
            binding.simpleImageView.visibility = View.VISIBLE
            binding.imagesRecyclerView.visibility = View.GONE
            val url = imagesBean[0].url
            imageLoader.displayImage(
                url, binding.simpleImageView
            )
            binding.simpleImageView.tag = url
            imagesAdapter.images = null
        } else {
            binding.simpleImageView.visibility = View.GONE
            binding.imagesRecyclerView.visibility = View.VISIBLE
            imagesAdapter.images =
                imagesBean.asSequence().map { it.url ?: "" }.filter { it.isNotEmpty() }.toList()
        }
    }

    private fun setupCommentsView(commentsView: RecyclerView) {
        commentsView.layoutManager = LinearLayoutManager(itemView.context)
        commentsAdapter = CommentsAdapter()
        commentsView.adapter = commentsAdapter

        commentsView.addItemDecoration(
            MarginItemDecoration(
                RecyclerView.VERTICAL,
                itemView.context.dip(5)
            )
        )
    }

    private fun addTweetImagesView() {
        imagesAdapter = ImagesAdapter()
        binding.imagesRecyclerView.addItemDecoration(ImagesDecoration(itemView.context.dip(5)))
        binding.imagesRecyclerView.adapter = imagesAdapter
    }*/
}