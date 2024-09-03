package com.hfad.dailyquotes.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hfad.dailyquotes.R
import com.hfad.dailyquotes.model.Quotedataclass
import com.hfad.dailyquotes.database.QuoteDataBase
import com.hfad.dailyquotes.databinding.FragmentQuotesBinding
import com.hfad.dailyquotes.mainActivity.MainActivity
import com.hfad.dailyquotes.repository.QuoteRepository
import com.hfad.dailyquotes.viewModels.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuotesFragment : Fragment() {
    private  var _binding: FragmentQuotesBinding? = null
    private val binding get() = _binding!!
    private  val viewModel: QuoteViewModel by viewModels()
    private val args by navArgs<QuotesFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuotesBinding.inflate(inflater, container, false)



        val getName = args.name
        binding.headerTitle.text = getName

        viewModel.quotes.observe(viewLifecycleOwner){
            viewModel.updateQuoteIndex()
            Log.e("UserQuotes", "UserQuotes: $it")
        }

        viewModel.getQuotesByCategory(getName)

        viewModel.currentQuote.observe(viewLifecycleOwner){
            quote ->
            quote?.let {
                setQuotesToTextView(it)
            }
        }

        binding.copyBtn.setOnClickListener{
                viewModel.currentQuote.value?.let {
                    currentQuote ->
                    val combinedText = "${currentQuote.quoteText} -${currentQuote.quoteAuthor}"
                    // copy the combined text to the clipboard
                    val clipboard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("Quote", combinedText)
                    clipboard.setPrimaryClip(clip)
                    // show text
                    Toast.makeText(requireContext(), " copied to clipboard!", Toast.LENGTH_SHORT).show()
                }
        }


        // set prev button to get previous quote
        binding.prevButton.setOnClickListener{
            viewModel.previousQuote()
        }

        // set next button to get next quote
        binding.nextButton.setOnClickListener{
            viewModel.nextQuote()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navButton.setOnClickListener {
            findNavController()
                .navigate(R.id.action_quotesFragment_to_addQuoteFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).hideBottomNav()
    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).showBottomNav()
    }

    private fun setQuotesToTextView(quote: Quotedataclass) {

        // get quotes from list from current position
        binding.quoteContent.text = quote.quoteText

        // get quotes from list from current position
        binding.writerName.text = quote.quoteAuthor

        binding.heartCheckbox.setOnCheckedChangeListener(null)

        binding.heartCheckbox.isChecked = quote.isFavorite
        
        binding.heartCheckbox.setOnCheckedChangeListener{
                _, isChecked ->
            viewModel.updateQuoteIsFavorite(isChecked)
            if (isChecked){
                Toast.makeText(requireContext(),"Quotes added to favorites",Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(requireContext(),"Quotes removed from favorites",Toast.LENGTH_SHORT).show()
            }
        }
    }

}
