package nur.xan.app.windows.gifts.infoGifts

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import nur.xan.app.databinding.FragmentInfoGiftsBinding

class InfoGiftsFragment : Fragment() {

    private var _binding: FragmentInfoGiftsBinding? = null
    private val binding get() = _binding!!

    private var isButtonAtBottom = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoGiftsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            if (isButtonAtBottom) {
                // Анимация для возврата кнопки в исходное положение
                val slideUpAnimation = ValueAnimator.ofFloat(binding.giftTitle.translationY, 0f)
                slideUpAnimation.duration = 300 // Длительность анимации (в миллисекундах)
                slideUpAnimation.interpolator =
                    AccelerateDecelerateInterpolator() // Интерполятор для плавного движения
                slideUpAnimation.addUpdateListener { animator ->
                    val animatedValue = animator.animatedValue as Float
                    binding.giftTitle.translationY = animatedValue
                }
                slideUpAnimation.addListener(object : Animator.AnimatorListener {


                    override fun onAnimationStart(p0: Animator) {
                    }

                    override fun onAnimationEnd(p0: Animator) {
                        binding.giftImage.visibility = View.GONE
                    }

                    override fun onAnimationCancel(p0: Animator) {
                    }

                    override fun onAnimationRepeat(p0: Animator) {
                    }
                })
                slideUpAnimation.start()
            } else {
                val slideDistance = 250 // Расстояние, на которое нужно сдвинуть кнопку
                // Анимация для спуска кнопки вниз
                val slideDownAnimation = ValueAnimator.ofFloat(0f, slideDistance.toFloat())
                slideDownAnimation.duration = 300 // Длительность анимации (в миллисекундах)
                slideDownAnimation.interpolator =
                    AccelerateDecelerateInterpolator() // Интерполятор для плавного движения
                slideDownAnimation.addUpdateListener { animator ->
                    val animatedValue = animator.animatedValue as Float
                    binding.giftTitle.translationY = animatedValue
                }
                slideDownAnimation.addListener(object : Animator.AnimatorListener {

                    override fun onAnimationStart(p0: Animator) {
                    }

                    override fun onAnimationEnd(p0: Animator) {
                        binding.giftImage.visibility = View.VISIBLE
                    }

                    override fun onAnimationCancel(p0: Animator) {
                    }

                    override fun onAnimationRepeat(p0: Animator) {
                    }
                })
                slideDownAnimation.start()
            }
            isButtonAtBottom = !isButtonAtBottom
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
