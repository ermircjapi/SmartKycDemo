import {Component, OnInit} from '@angular/core';
import {SmartKycService} from '../shared';

@Component({
  selector: 'app-smart-kyc',
  templateUrl: './smart-kyc.component.html',
  styleUrls: ['./smart-kyc.component.css'],
  providers: [SmartKycService]
})
export class SmartKycComponent implements OnInit {
  dominoPieces: any;
  highestValue: number;

  constructor(private smartKycService: SmartKycService) {
  }

  ngOnInit() {
    this.smartKycService.getChainWithHighestValue(this.dominoPieces).subscribe(
      value => {
        this.highestValue = value;
      },
      error => console.log(error)
    );
  }
}
