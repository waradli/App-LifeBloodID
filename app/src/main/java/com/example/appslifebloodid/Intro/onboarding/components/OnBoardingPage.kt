package com.example.appslifebloodid.Intro.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appslifebloodid.Intro.Dimens.MediumPadding1
import com.example.appslifebloodid.Intro.Dimens.MediumPadding2
import com.example.appslifebloodid.Intro.onboarding.Page
import com.example.appslifebloodid.Intro.onboarding.pages
import com.example.appslifebloodid.R
import com.example.appslifebloodid.ui.theme.AppsLifeBloodIDTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
){
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(130.dp))
        Image(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = page.imageSizeFraction),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(text = page.description,
            modifier = Modifier
                .padding(horizontal = MediumPadding2)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyMedium.copy(
                textAlign = TextAlign.Center),
            color = colorResource(id = R.color.black)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    AppsLifeBloodIDTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}